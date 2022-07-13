import "./CryptocurrencyPricePage.css";

import {Banner} from "../../components/common_components/banner/Banner";
import {Form} from "../../components/cryptocurrency_price_page_components/form/Form";

function CryptocurrencyPricePage(){
    return(
        <>
            <Banner title="Cryptocurrency price"/>
            <Form/>
        </>
    );
}

export {CryptocurrencyPricePage}