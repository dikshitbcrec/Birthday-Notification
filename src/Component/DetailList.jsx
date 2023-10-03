import { Button } from '@mui/material';
import './DetailList.css';


const DetailsList=({name,bday,flag})=>{

    return(
       
        <div className='card'>
          <div className='card-main'>
            <h3>{name}</h3>
            <p>Birthday Date : {bday}</p>
            {flag?<img className='img-path' src='happy.avif'/>:<img className='img-path' src='waitBday.webp'/>}
            <br></br>
            <button className={flag?"button":"button1"} disabled={flag?true:false}>{flag?"Notified":"Wait Your Bday is coming"}</button>
          </div>
       </div>
        
        );


}
export default DetailsList;

