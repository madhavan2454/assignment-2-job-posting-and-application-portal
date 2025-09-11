import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import CandidateList from './Components/CandidateList'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <HeaderComponent />
    <CandidateList />
    <FooterComponent />
    </>
  )
}

export default App
