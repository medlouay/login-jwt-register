
import './App.css';
import Register from './compontents/Register.jsx';
import { BrowserRouter,Routes,Route } from "react-router-dom";
import Login from "./compontents/Login.jsx";
import Home from "./compontents/Home.jsx";

function App() {
  return (
    <div className="App">
       <div>
 
 <BrowserRouter>
       <Routes>
         <Route path="/home" element= { <Home/>} />
         <Route path="/register" element= { <Register/>} />
         <Route path="/" element= { <Login/>} />
       </Routes>
   </BrowserRouter>
 
</div>
    </div>
  );
}

export default App;
