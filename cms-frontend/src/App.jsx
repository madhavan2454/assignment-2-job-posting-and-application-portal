import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import CandidateList from './Components/CandidateList'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import CandidateComponent from './Components/CandidateComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
           { /*//http://localhost:3000/ */}
           <Route path ='/' element={ <CandidateList />}></Route>
           {/* //http://localhost:3000/CandidateList */}
           <Route path ='/CandidateList' element={ <CandidateList />}></Route>
           {/* //http://localhost:3000/add-candidate */}
           <Route path ='/add-candidate' element={ <CandidateComponent />}></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
