import "./NotifyForm.css"
import React from "react";
import axios from "axios";
import { useNavigate } from 'react-router';

function NotifyForm(){

    const navigate = useNavigate();
    let cryptocurrencySymbol = React.createRef();
    let username = React.createRef();

    const[info, setInfo] = React.useState("");

    const API_URL  = "http://localhost:8080/watchers/notify";

    const notify = (cryptocurrencySymbol, username) => {
        console.log("hello! " + username + "   " + cryptocurrencySymbol);

        axios
            .post(API_URL, {
                username: username.current.value,
                symbol: cryptocurrencySymbol.current.value,
            })
            .then((response) => {
                setInfo("gOOD!")
            })
            .catch(() => setInfo("Error!"));
    }

    return(
        <>
            <h3>Enter your username</h3>
            <input type="text" ref={username}/>
            <h3>Enter the cryptocurrency symbol</h3>
            <input type="text" ref={cryptocurrencySymbol}/>
            <button onClick={() => notify(cryptocurrencySymbol, username)}/>
            <div>{info}</div>
        </>
    );
}

export {NotifyForm}