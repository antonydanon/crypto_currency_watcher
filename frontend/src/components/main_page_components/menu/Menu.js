import "./Menu.css";
import {Link} from "react-router-dom";

function ServicesInfo(){
    return(
        <div className="main">
            <div className="services">
                <Link className="link" to="/available-cryptocurrencies">Show available cryptocurrencies</Link>
                <Link className="link" to="/cryptocurrency-price">Show cryptocurrency price</Link>
                <Link className="link" to="/">Subscribe to the сryptocurrency сhange</Link>
            </div>
        </div>
    );
}

export {ServicesInfo}