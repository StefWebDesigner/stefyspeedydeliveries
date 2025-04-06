import axios from "axios";


class UserService {

    async registerUser(firstname, lastname, email, password, role){
        return await axios.post("http://localhost:8080/api/v1/auth/register",
            {
                firstname,
                lastname,
                email,
                password,
                role
            });
    }



}

export default UserService;