import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route, BrowserRouter, useNavigate} from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import AdminPortalComponent from './components/AdminPortalComponent';


function App() {
  return (
    <>
      <Router>
        <Routes>
            <Route path="/" element={<HomeComponent/>} />
            <Route path="/admin" element={<AdminPortalComponent/>} />

        </Routes>
      </Router>
    </>
  );
}

export default App;
