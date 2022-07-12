import "./Menu.css";
import {Link} from "react-router-dom";

function ServicesInfo(){
    return(
        <div className="main">
            <div className="services">
                <Link className="link" to="/">Show available cryptocurrencies</Link>
                <Link className="link" to="/">Show cryptocurrency price</Link>
                <Link className="link" to="/">Subscribe to the сryptocurrency сhange</Link>
            </div>
        </div>
    );
}

export {ServicesInfo}