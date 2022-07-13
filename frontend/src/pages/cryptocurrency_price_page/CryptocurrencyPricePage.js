import "./CryptocurrencyPricePage.css";

import {Banner} from "../../components/main_page_components/banner/Banner";
import {Form} from "../../components/cryptocurrency_price_page_components/form/Form";

function CryptocurrencyPricePage(){
    return(
        <>
            <Banner/>
            <Form/>
        </>
    );
}

export {CryptocurrencyPricePage}