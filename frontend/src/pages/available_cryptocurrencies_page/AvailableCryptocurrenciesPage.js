import "./AvailableCryptocurrenciesPage.css";

import {Banner} from "../../components/main_page_components/banner/Banner";
import {AvailableCryptocurrencies} from "../../components/available_cryptocurrencies_page_components/AvailableCryptocurrencies";

function AvailableCryptocurrenciesPage(){
    return(
        <>
            <Banner/>
            <AvailableCryptocurrencies/>
        </>
    );
}

export {AvailableCryptocurrenciesPage}