import { Container, TextField } from "@mui/material";
import { useEffect, useState } from "react";
import DetailsList from "./DetailList";
import NavBar from "./NavBar";
import Spinner from "./Spinner";
const BASE_URL='http://localhost:8080/v1/birthday';
const AllBdayDetails=()=>{
    const [search,setSearch]=useState("");
    const [loading,setLoading]=useState(false);
    const [storage,setStorage]=useState([]);



    useEffect(()=>{
        const allDetails=async()=>{
                try{
                    setLoading(true);
                            const res= await fetch(`${BASE_URL}/findBy?name=${search}`);
                            const data=await res.json();
                           // console.log(data);
                            setStorage(data);
                    setLoading(false);
                }
                catch(error){
                    alert("error in getting details")
                }
        }
        allDetails();
    },[search])


    return (
        <header className="header">
            <NavBar/>
        <Container maxWidth="md" sx={{ mt: 5}}>
        <TextField inputProps={{ style: { color: "red" } }}style={{width:'100%',color:"white"}} value={search}  onChange={(e)=>setSearch(e.target.value)}  type="search" id="search" label="Friend Name" sx={{ width: 600 }} />
        </Container>
        {loading?<Spinner/>:''}
        {
        
        storage.length>0?storage.map((data)=><DetailsList name={data.name} bday={data.bdayDate} flag={data.enable} key={data.id}/>):"No data Found"
        
        } 
   
       
        
        </header>
    )



}
export default AllBdayDetails;