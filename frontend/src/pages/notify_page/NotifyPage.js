import "./NotifyPage.css";

import {Banner} from "../../components/main_page_components/banner/Banner";
import {NotifyForm} from "../../components/notify_page_components/notify_form/NotifyForm";

function NotifyPage(){
    return(
        <>
            <Banner/>
            <NotifyForm/>
        </>
    );
}

export {NotifyPage}