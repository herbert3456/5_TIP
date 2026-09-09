import { useState } from 'react'
import './Cars.css'
const Cars = () => {
    const [Imie, setImie] = useState('');
    const [Nazwisko, setNazwisko] = useState('');
    const [Wiek, setWiek] = useState('');
    const [result, setResult] = useState('-');
    function handleRegistration() {
        let Wieks = parseInt(Wiek);
        //alert(`Email: ${email}, Hasło: ${password}, Powtórzone hasło: ${confirmPassword}`);
        if(Imie.length < 2) {
            setResult('Niepoprawne imię');
            return;
        }
        if(Nazwisko.length < 2) {
            setResult('Niepoprawne nazwisko');
            return;
        }
        if(!Wiek || Wieks < 18) {
            setResult('Niepoprawny wiek musisz miec 18 lat');
            return;
        }
        setResult('Rejestracja zakończona sukcesem');
    }

    return (
        <section className="registration">
            <h2>Rejestracja na prawo jazdy</h2>
            <label htmlFor="imie">
                Podaj imię:
            </label>
            <input id="imie" type="text"
                value={Imie}
                onChange={(e) => setImie(e.target.value)}
                placeholder="Wpisz imię" />
           
            <label htmlFor="nazwisko">
                Podaj nazwisko:
            </label>
            <input id="nazwisko" type="text"
                value={Nazwisko}
                onChange={(e) => setNazwisko(e.target.value)}
                placeholder="Wpisz nazwisko" />
            <label htmlFor="wiek">
                Podaj wiek:
            </label>
            <input id="wiek" type="number"
                value={Wiek}
                onChange={(e) => setWiek(e.target.value)}
                placeholder="Wpisz wiek" />
            
            <button onClick={() => handleRegistration()}>ZATWIERDŹ</button>
            <section>{result}</section>
        </section>
    )
}
export default Cars