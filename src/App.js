
import AddBirthDay from './Component/AddBirthday';
import AllBdayDetails from './Component/AllBdayDetails';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

function App() {
  return (
    
  <BrowserRouter>
  <Routes>
    <Route path="/" element={<AddBirthDay/>} />
    <Route path="/display" element={<AllBdayDetails/>} />
  </Routes>
  </BrowserRouter>
  
  
    
      
   
  );
}

export default App;
