import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route, BrowserRouter, useNavigate} from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import AdminPortalComponent from './components/AdminPortalComponent';
import RegistrationComponent from './components/userComponents/RegistrationComponent';
import LoginComponent from './components/authComponents/LoginComponent';


function App() {
  return (
    <>
      <Router>
        <Routes>
            <Route path="/" element={<HomeComponent/>} />
            <Route path="/admin" element={<AdminPortalComponent/>} />
            <Route path="/register" element={<RegistrationComponent/>} />
            <Route path="/login" element={<LoginComponent/>} />

        </Routes>
      </Router>
    </>
  );
}

export default App;
