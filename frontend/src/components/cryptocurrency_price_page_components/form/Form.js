import "./Form.css"
import React from "react";
import axios from "axios";

function Form(){

    let cryptocurrencySymbol = React.createRef();

    const API_URL  = "http://localhost:8080/cryptocurrencies/price";

    const[cryptocurrencyPrice, setCryptocurrencyPrice] = React.useState("");

    const getCryptocurrencyPrice = () => {
        axios.get(API_URL,{
            params: {
                symbol: cryptocurrencySymbol.current.value
            }
        })
            .then((response) => {
                setCryptocurrencyPrice(response.data+"$");
            })
            .catch((error) => setCryptocurrencyPrice(error.response.data))
    }

    return(
        <div className="form">
            <div className="form-element">
                <div>
                    <span className="form-text">Enter the cryptocurrency symbol</span>
                </div>
                <input className="form-input" type="text" ref={cryptocurrencySymbol}/>
            </div>
            <div className="form-element">
                <button className="form-button" onClick={() => getCryptocurrencyPrice(cryptocurrencySymbol)}>Click</button>
            </div>
            <div className="form-element">
                <span className="result">{cryptocurrencyPrice}</span>
            </div>
        </div>
    );
}

export {Form}