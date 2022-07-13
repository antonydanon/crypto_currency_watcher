import "./Form.css"
import React from "react";
import axios from "axios";

function Form(){

    let cryptocurrencySymbol = React.createRef();

    const API_URL  = "http://localhost:8080/cryptocurrencies/price/";

    const[cryptocurrencyPrice, setCryptocurrencyPrice] = React.useState("");

    const getCryptocurrencyPrice = () => {
        axios.get(API_URL + cryptocurrencySymbol.current.value)
            .then((response) => {
                console.log(response.data);
                setCryptocurrencyPrice(response.data);
            })
            .catch(() => setCryptocurrencyPrice("Error!"))
    }

    return(
        <>
            <h3>Enter the cryptocurrency symbol</h3>
            <input type="text" ref={cryptocurrencySymbol}/>
            <button onClick={() => getCryptocurrencyPrice(cryptocurrencySymbol)}/>
            <div>{cryptocurrencyPrice}</div>
        </>
    );
}

export {Form}