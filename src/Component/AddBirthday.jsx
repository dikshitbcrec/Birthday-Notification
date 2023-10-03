import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Input from '@mui/material/Input';
import { useEffect, useState } from 'react';
import { Button } from '@mui/material';
import BirthdayDetails from '../Model/Birthday.class';
import './AddBirthday.css';
import NavBar from './NavBar';

const BASE_URL="http://localhost:8080/v1/birthday/"
 
const AddBirthDay=()=>{
    const [name,setUseName]=useState("");
    const [email,setEmail]=useState("");
    const [date,setDate]=useState("");
    const [flag ,setFlag]=useState(true);   
    
    
  
const handle=(e)=>
{
      e.preventDefault();
      const bday=new BirthdayDetails(name,email,date);
      console.log(bday)
      
      const add_data=async(bday)=>{
        try{
          const response=await fetch(BASE_URL,{
            method:"POST",
            headers:{
              "Content-type":"application/json",
            },
            body:JSON.stringify(bday)

          });
          const result=await response.json();
          console.log(result);
          alert("Suucess Submitted Data")
          setUseName("");
          setEmail("");
          setDate("");
        }
        catch(error)
        {
          console.log(error);
        }

      }
      add_data(bday);
    };   


    useEffect(()=>{
        if(name && email && date)
        {
          setFlag(true);
        }
        else{
          setFlag(false);
        }
    },[name,email,date])
    
   
    
    return(

<div className='main'>
<NavBar/>
<Box className="bdayPart">
<h1>Add Birthday Details</h1>
  <div className='form-class'>
    <form className='form-content'  onSubmit={handle}>
      <TextField  sx={{ m: 1,width:'50ch' }} id="outlined-basic" label="Name" value={name} required onChange={(e)=>(setUseName(e.target.value))} variant="outlined" />      
     <br/>
        <FormControl fullWidth sx={{ m: 1,width:'50ch',height:'10ch' }} variant="standard">
          <InputLabel htmlFor="standard-adornment-amount">E-Mail</InputLabel>
          <Input value={email}  onChange={(e)=>setEmail(e.target.value)}
            id="standard-adornment-amount" type='email' required
            startAdornment={<InputAdornment position="start">@</InputAdornment>}
          />
          
        </FormControl>
        <br/>
        <FormControl fullWidth sx={{ m: 1,width:'50ch' }} variant="standard">
          <Input  value={date} onChange={(e)=>setDate(e.target.value)} type='date'/>
        </FormControl>
        <br></br>
        <Button type='submit' disabled={flag?false:true}  variant="contained" sx={{m:1,width:'25ch',height:'8ch'}} color="success">Add 🎈</Button>
        </form>
        <div>
          <img className='img-bday' src='bday.png' alt='birthday-img'/>
        </div>
      </div>    
    </Box>
  </div>




       
    )


}
export default AddBirthDay;