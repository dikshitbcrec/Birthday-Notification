import { NavLink } from 'react-router-dom';
import './NavBar.css';

const NavBar=()=>{
return (
 <li className='li'>
    <ul>
        <NavLink to='/' >Add B-day Details</NavLink>
    </ul>
    <ul> <NavLink to='/display' >Show Bday</NavLink></ul>
 </li>  
);


}
export default NavBar;