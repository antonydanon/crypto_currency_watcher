import "../common_styles/Background.css";

import {Banner} from "../../components/common_components/banner/Banner";
import {ServicesInfo} from "../../components/main_page_components/menu/Menu";

function MainPage(){
    return(
        <>
            <Banner title="CryptoСurrency watcher"/>
            <ServicesInfo/>
        </>
    );
}

export {MainPage}