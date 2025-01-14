import './App.css';
import 'bootstrap/dist/css/bootstrap.css'
import React, {useEffect, useState} from 'react'
import {ProductList} from "./components/ProductList";
import {Summary} from "./components/Summary";
import axios from "axios";

function App() {
  const [products, setProducts] = useState([
    {id: 'uuid-2', productName : '나이키 옷', category : 'CLOTHS', price : 15000},
    {id: 'uuid-3', productName : '아디다스 바지', category : 'PANTS', price : 25000},
    {id: 'uuid-4', productName : '반스 신발', category : 'VANS', price : 50000},
  ]);
  const [items, setItems] = useState([]);
  const handleAddClicked = id => {
    const product = products.find(v => v.id === id);
    const found = items.find(v => v.id === id);
    const updatedItems = found ? items.map(v => (v.id === id) ? {...v, count: v.count+1} : v ) : [...items, {...product, count : 1}]
    setItems(updatedItems);
    console.log(id);
  }

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/products')
    .then(v => setProducts(v.data));
  }, []);

  const handleOrderSubmit = (order) => {
    if(items.length===0) {
      alert("아이템을 추가해 주세요.")
    } else {
      axios.post("http://localhost:8080/api/v1/orders", {
        email: order.email,
        address: order.address,
        postcode: order.postcode,
        orderItems: items.map(v => ({
          productId: v.productId,
          category: v.category,
          price: v.price,
          quantity: v.count
        }))
      }).then(
          v => alert("주문이 정상적으로 접수되었습니다."),
          e => {
            alert("서버 장애");
            console.log(e);
          })
    }
  }

  return (
      <div className="container-fluid">
        <div className="row justify-content-center m-4">
          <h1 className="text-center">Grids &amp; Circle</h1>
        </div>
        <div className="card">
          <div className="row">
            <div className="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
              <ProductList products={products} onAddClick={handleAddClicked}/>
            </div>
            <div className="col-md-4 summary p-4">
              <Summary items={items} onOrderSubmit={handleOrderSubmit}/>
            </div>
          </div>
        </div>
      </div>
  );
}

export default App;