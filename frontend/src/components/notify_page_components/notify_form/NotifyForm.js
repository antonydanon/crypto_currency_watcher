import "./NotifyForm.css"
import React from "react";
import axios from "axios";
import { useNavigate } from 'react-router';

function NotifyForm(){

    const[info, setInfo] = React.useState("");
    let cryptocurrencySymbol = React.createRef();
    let username = React.createRef();

    const API_URL  = "http://localhost:8080/watchers/notification";

    const notify = (cryptocurrencySymbol, username) => {
        axios
            .post(API_URL, {
                username: username.current.value,
                symbol: cryptocurrencySymbol.current.value,
            })
            .then((response) => {
                setInfo(response.data)
            })
            .catch((error) => setInfo(error.response.data));
    }

    return(
        <div className="notify-form">
            <div className="notify-form-element">
                <div>
                    <span className="notify-form-text">Enter your username</span>
                </div>
                <input className="notify-form-input" type="text" ref={username}/>
            </div>
            <div className="notify-form-element">
                <div>
                    <span className="notify-form-text">Enter the cryptocurrency symbol</span>
                </div>
                <input className="notify-form-input" type="text" ref={cryptocurrencySymbol}/>
            </div>
            <div className="notify-form-element">
                <button className="notify-form-button" onClick={() => notify(cryptocurrencySymbol, username)}>Click</button>
            </div>
            <div className="notify-form-element">
                <span className="notify-result">{info}</span>
            </div>
        </div>
    );
}

export {NotifyForm}