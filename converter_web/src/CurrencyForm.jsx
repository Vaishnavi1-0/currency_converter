import { useEffect, useState } from "react";
import axios from 'axios';
function CurrencyConverter(props){

    const [currencies, setCurrencies] = useState([{label:"USD", value:"USD"}, {label:"INR", value:"INR"}, {label:"JPY", value:"JPY"}, {label:"EUR", value:"EUR"}]);
    const [targetValue, setTargetValue] = useState(0);
    const [sourceAmount, setSourceAmount] = useState();
    const [sourceCurrency, setSourceCurrency] = useState("");
    const [targetCurrency, setTargetCurrency] = useState("");
    const [exchangeRate, setExchangeRate] = useState("");


    useEffect(()=>{
        if(sourceCurrency !== "" && targetCurrency !== "" && sourceAmount !== ""){ 
        axios.get("http://localhost:8080/currency/converter",{
            params: {
                sourceCurrency:sourceCurrency.toLowerCase(),
                sourceAmount: sourceAmount,
                targetCurrency: targetCurrency.toLowerCase()
            }
        })
        .then((response) =>{
            console.log(response.data.targetCurrency+" "+response.data.exchangeRate);
            setTargetValue(response.data.targetCurrency);
            setExchangeRate(response.data.exchangeRate);
        })
    }   
    },[targetCurrency, sourceCurrency, sourceAmount]);

    return(
        <div>
            <label>Source Currency:</label>
            <select  value={sourceCurrency} onChange={(e)=>setSourceCurrency(e.target.value)}>
            <option>Select Source Currency</option>
                {currencies.map((c)=>
                <option value={c.value}>{c.label}</option>
                )}
            </select><br/>
            <label>Enter Amount:</label>
            <input type='number' onChange={(e)=>setSourceAmount(e.target.value)}></input><br/>
            <label>Target currency:</label>
            <select value={targetCurrency} onChange={(e)=>setTargetCurrency(e.target.value)}>
            <option>Select Target Currency</option>
                {currencies.map((c)=>
                <option value={c.value}>{c.label}</option>
                )}
            </select><br/>
            <label>Amount: <span>{targetCurrency}&nbsp;{targetValue}</span></label><br/>
                    <label>Exchange rate:</label><span>{targetCurrency}&nbsp;{exchangeRate}</span>
        </div>
    )
}
export default CurrencyConverter;