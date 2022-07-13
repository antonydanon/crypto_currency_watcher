import React from 'react';
import axios from 'axios';
import "./AvailableCryptocurrencies.css";

function AvailableCryptocurrencies(){

    const API_URL  = "http://localhost:8080/cryptocurrencies";

    const[listOfAvailableCryptocurrencies, setListOfAvailableCryptocurrencies] = React.useState([]);

    React.useEffect((() => {
        axios.get(API_URL)
            .then((response) => {
                console.log(response.data);
                setListOfAvailableCryptocurrencies(response.data);
            })
            .catch(() => setListOfAvailableCryptocurrencies([]))
    }), [])


    return(
        <>
            <div className="available-cryptocurrencies-header">
                <h1>Available cryptocurrencies</h1>
            </div>
            <div className="available-cryptocurrencies-list">
                    {listOfAvailableCryptocurrencies.map((availableCryptocurrency) => (
                            <div className="author">
                                {availableCryptocurrency.id} {availableCryptocurrency.symbol} {availableCryptocurrency.priceUsd}
                            </div>
                        ))}
            </div>
        </>
    );
}

export {AvailableCryptocurrencies}