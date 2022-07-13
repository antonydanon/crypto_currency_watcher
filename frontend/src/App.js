import {Route, Routes} from "react-router-dom";
import {MainPage} from "./pages/main_page/MainPage"
import {AvailableCryptocurrenciesPage} from "./pages/available_cryptocurrencies_page/AvailableCryptocurrenciesPage";
import {CryptocurrencyPricePage} from "./pages/cryptocurrency_price_page/CryptocurrencyPricePage";
import {NotifyPage} from "./pages/notify_page/NotifyPage";

function App() {
    return (
        <>
            <Routes>
                <Route path='/' element={<MainPage/>}/>
                <Route path='/available-cryptocurrencies' element={<AvailableCryptocurrenciesPage/>}/>
                <Route path='/cryptocurrency-price' element={<CryptocurrencyPricePage/>}/>
                <Route path='/notify' element={<NotifyPage/>}/>
            </Routes>
        </>
    );
}

export default App;
