import "./MainPage.css";

import {Banner} from "../../components/main_page_components/banner/Banner";
import {ServicesInfo} from "../../components/main_page_components/menu/Menu";

function MainPage(){
    return(
        <>
            <Banner/>
            <ServicesInfo/>
        </>
    );
}

export {MainPage}