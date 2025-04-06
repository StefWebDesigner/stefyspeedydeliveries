import React, { useState } from 'react'
import NavComponent from '../navigation/NavComponent'
import {Button, Card, Container, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";
import UserService from '../../services/UserService';
import { useNavigate } from 'react-router-dom';

function RegistrationComponent() {

    let userService = new UserService();

    const navigate = useNavigate()

    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [role, setRole] = useState("");
    const [password, setPassword] = useState("");
    const [message,setMessage]=useState("")
    const [error,setError]=useState(false);



    async function registerUserForm(e){
        e.preventDefault()
        await userService.registerUser(firstname, lastname, password, email, role).then(response=> {

            // if (!username.value.trim()) {
            const emailFormat =
                /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

            // const usernameFormat =
            //     "[A-Za-z0-9@._-]{8,50}$";
            if(response.data) {
                console.log(e.target.email.value)

                let email = e.target.email.value.trim();
                let firstName = e.target.firstname.value.trim();
                let lastName = e.target.lastname.value.trim();
                let password = e.target.password.value.trim();
                let role = e.target.role.value.trim();

                // if (!email.match(emailFormat) || email.trim() == null){
                if (email == null){
                    console.log("enter here");
                    setError(true)
                    setMessage("Check email input");
                    console.log(message);

                    return null;
                } else if (firstName == null){
                    setError(true)
                    setMessage("Check firstName input");
                    console.log(message);
                    return null;
                } else if (lastName == null){
                    setError(true)
                    setMessage("Check lastName input");
                    console.log(message);
                    return null;
                } else if(password == null){
                    setError(true)
                    setMessage("Check password input");
                    console.log(message);
                    return null;
                } else if(error == false){
                    setError(false)
                    setFirstname(response.data.firstname);
                    setLastname(response.data.lastname);
                    setPassword(response.data.package)
                    setEmail(response.data.email);
                    setRole(response.data.role);
                    alert("You have sucessfully registered!")
                    navigate("/")

                } else {
                    console.log("Fuck off")
                }



            }


        }).catch(err => {
            console.log("Enter the catch");

            setError(true)
            setMessage(err.response.data.message);
            console.log(err.response.data.message);
        });

        setError(false)
        setFirstname("")
        setLastname("")
        setPassword("")
        setEmail("");
        setRole("");


    }
       




  return (
    <>
        <Container>

        <NavComponent/>

        <h1 className="registration-title">Let's Register For An Account</h1>

        <Card className="registration-card-container">
            <Form onSubmit = {registerUserForm}>
                <FormGroup className = "registration-form-container">
                    <FormLabel className = "registration-form-label">
                        <p>
                            Firstname
                        </p>
                    </FormLabel>
                    <FormControl
                        className="registration-form-placeholder"
                        type="text"
                        name="firstname"
                        placeholder="firstname"
                        onChange={(e) => (setFirstname(e.target.value))}
                        required
                    />
                </FormGroup>
                <FormGroup className = "registration-form-container">
                    <FormLabel className = "registration-form-label">
                        <p>
                            Lastname
                        </p>

                    </FormLabel>
                    <FormControl
                        className="registration-form-placeholder"
                        type="text"
                        name="lastname"
                        placeholder="lastname"
                        onChange={(e) => (setLastname(e.target.value))}
                        required
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel className = "registration-form-label">
                        <p>
                            Password
                        </p>
                    </FormLabel>
                    <FormControl
                        className="registration-form-placeholder"
                        type="text"
                        name="password"
                        placeholder="password"
                        onChange={e => (setPassword(e.target.value))}
                        required
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel className = "registration-form-label">
                        <p>
                            Email
                        </p>
                    </FormLabel>
                    <FormControl
                        className="registration-form-placeholder"
                        type="text"
                        name="email"
                        placeholder="Email"
                        onChange={e => (setEmail(e.target.value))}
                        required
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel className = "registration-form-label">
                        <p>
                            role
                        </p>
                    </FormLabel>
                    <Form.Select
                        name="role"
                        placeholder="Role"
                        onChange={e => (setRole(e.target.value))}
                        required
                    >
                        <option value=""> Select </option>
                        {/* <option value="ROLE_USER"> ROLE_USER</option>
                        <option value="ROLE_ADMIN"> ROLE_ADMIN</option> */}
                        <option value="USER"> USER</option>
                        <option value="ADMIN"> ADMIN</option>
                        
                    </Form.Select>

                </FormGroup>
                <div className="registration-form-button-group">
                    <Button
                        className="registration-form-button"
                        type="submit"
                    >
                        Enter
                    </Button>
                </div>
                <div>
                    {error && (<>{<p className="errorMessage">{message}</p>}</>)}
                </div>




            </Form>
        </Card>

        </Container>
    </>
  )
}

export default RegistrationComponent;