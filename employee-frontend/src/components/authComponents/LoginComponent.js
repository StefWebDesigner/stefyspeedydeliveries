import React, { useContext, useState } from 'react'
import NavComponent from '../navigation/NavComponent'
import Auth from '../../services/Auth';
import { useNavigate } from 'react-router-dom';
import { Form, Button, FormGroup, FormLabel, FormControl, FormCheck } from 'react-bootstrap';
import { AuthContext } from '../../utility/dataStore';


function LoginComponent({onSubmit ,email, setEmail, password, setPassword}) {

        let auth = new Auth();
        const authContext = useContext(AuthContext);
    
        const [error,setError]=useState(false);
        const [message,setMessage]=useState("")
        const navigate=useNavigate();
    
    
    
        // @ts-ignore
        return (
            <>
                <Form className="login-form-container" onSubmit={onSubmit}>
                    <div className="login-form-background">
                        <FormGroup>
                            <FormLabel className="login-form-label"> email </FormLabel>
                            <FormControl
                                type="text"
                                name="email"
                                placeholder="email"
                                onChange={(e) => (setEmail(e.target.value))}
                            />
                        </FormGroup>
                        <FormGroup>
                            <FormLabel className="login-form-label">Password</FormLabel>
                            <FormControl
                                type="password"
                                name="password"
                                placeholder="password"
                                onChange={(e) => (setPassword(e.target.value))}
                            />
                        </FormGroup>
    
                        {/*<FormCheck*/}
                        {/*    className="login-form-label"*/}
                        {/*    type="checkbox"*/}
                        {/*    label="rememberme"*/}
                        {/*    defaultChecked={false}*/}
                        {/*    onChange={(e) => setRemember(!remember)}*/}
                        {/*/>*/}
    
                        <div className="login-form-button-group">
                            <Button
                                className="login-form-button"
                                type="submit"
                            >
                                Enter
                            </Button>
                        </div>
                        <div>
                            {error && (<>{message}</>)}
                        </div>
                    </div>
                </Form>
                
            </>
        );
    };

export default LoginComponent;