import React from 'react'
import {Link, useNavigate} from "react-router-dom";


function NavComponent() {
  return (
    <nav>
        <Link to="/admin" className="main-nav-link">
            Admin Portal
        </Link>
        <Link to="/register" className="main-nav-link">
            Register
        </Link>
        <Link to="/login" className="main-nav-link">
            Login
        </Link>

    </nav>
  )
}

export default NavComponent