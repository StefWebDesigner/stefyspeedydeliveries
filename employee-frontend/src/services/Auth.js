import axios from "axios";
import {useContext} from "react";

class Auth {

    async login(email, password){
        return await axios.post("http://localhost:8080/login",
            {
                email,
                password
            });
    }

    async getUser(email){
        return await axios.get("http://localhost:8080/user/getUser?email=" + email);
    }




    logout(){
        localStorage.removeItem("token");
        localStorage.removeItem("id");
        localStorage.removeItem("role");
        localStorage.removeItem("remember-me");
        localStorage.removeItem("email");
        localStorage.removeItem("firstname");
        localStorage.removeItem("lastname")
    }

}

export default Auth;