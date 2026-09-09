import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css'
const colors = ['red', 'green', 'blue', 'yellow', 'orange', 'purple', 'pink', 'brown', 'gray', 'black'];

function App() {
  

  return (
    <>
      <main className="container">
        <h2>Zabawa kolorami</h2>
        <section className="col-6">
          <select>
            {colors.map((color) => (
              <option key={color} value={color}>
                {color}
              </option>
            ))}
          </select>
        </section>
        <div className="scene">
          {colors.map((color) => (
            <div key={color} className="color-box" style={{ backgroundColor: color }} />
          ))}
        </div>
      
      </main>
    </>
  )
}

export default App
