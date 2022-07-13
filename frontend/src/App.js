import './App.css';
import {Route, Routes} from "react-router-dom";
import {MainPage} from "./pages/main_page/MainPage"
import {AvailableCryptocurrenciesPage} from "./pages/available_cryptocurrencies_page/AvailableCryptocurrenciesPage";
import {CryptocurrencyPricePage} from "./pages/cryptocurrency_price_page/CryptocurrencyPricePage";


function App() {
    return (
        <>
            <Routes>
                <Route path='/' element={<MainPage/>}/>
                <Route path='/available-cryptocurrencies' element={<AvailableCryptocurrenciesPage/>}/>
                <Route path='/cryptocurrency-price' element={<CryptocurrencyPricePage/>}/>
            </Routes>
        </>
    );
}

export default App;
