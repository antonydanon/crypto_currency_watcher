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
            <div className="available-cryptocurrencies-list">
                <div className="available-cryptocurrency">
                    <div className="item">ID</div>
                    <div className="item">Symbol</div>
                    <div className="item">Price USD</div>
                </div>
                {listOfAvailableCryptocurrencies.map((availableCryptocurrency) => (
                    <div className="available-cryptocurrency">
                        <div className="item">{availableCryptocurrency.id}</div>
                        <div className="item">{availableCryptocurrency.symbol}</div>
                        <div className="item">{availableCryptocurrency.priceUsd}$</div>
                    </div>
                ))}
            </div>
        </>
    );
}

export {AvailableCryptocurrencies}