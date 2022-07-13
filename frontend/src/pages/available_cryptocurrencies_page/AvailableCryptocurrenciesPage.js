import "../common_styles/Background.css";

import {Banner} from "../../components/common_components/banner/Banner";
import {AvailableCryptocurrencies} from "../../components/available_cryptocurrencies_page_components/available_cryptocurrencies/AvailableCryptocurrencies";

function AvailableCryptocurrenciesPage(){
    return(
        <>
            <Banner title="Available cryptocurrencies"/>
            <AvailableCryptocurrencies/>
        </>
    );
}

export {AvailableCryptocurrenciesPage}