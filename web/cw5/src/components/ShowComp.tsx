import './ShowComp.css'
import { useState } from 'react';

const ShowComp = () => {
    const [isCheked, setIsCheked] = useState(true);

    return (
        <section className="info">
            <img src="images/images.jpg" alt="Porshe" />
            <section className="d-flex flex-row align-items-center">
            <label htmlFor="showHide">
                Pokaż/Ukryj
                
            </label>
            <input type="form-check-input" id="showHide" />
        </section>   
    );
}
export default ShowComp;