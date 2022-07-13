import "../common_styles/Background.css";

import {Banner} from "../../components/common_components/banner/Banner";
import {NotifyForm} from "../../components/notify_page_components/notify_form/NotifyForm";

function NotifyPage(){
    return(
        <>
            <Banner title="Subscription to the price update"/>
            <NotifyForm/>
        </>
    );
}

export {NotifyPage}