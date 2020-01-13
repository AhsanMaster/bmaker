import React, {useState} from 'react';
import './AddUser.css';
import PropTypes from 'prop-types';


function AddUser({onCreate}){
    const[firstName, setFirstName]=useState('');
    const[lastName, setLastName]=useState('');
    const[email, setEmail]=useState('');
    const[year, setYear]=useState('');



    function onClick(){
        if(firstName.trim() && lastName.trim() && email.trim() && year.trim()){
            var data = {
                'firstName':firstName, 
                'lastName':lastName,
                'email':email,
                'year':year
            }
             onCreate(data)     
             setFirstName('');
             setLastName('')
             setEmail('')
             setYear('') 
        }else{
            alert('Not all fields are filled')
        }
    }
    

    
    return(
        <div style={{width:'100%'}}>
        <form  > 
                <label  className='usercreate'>First name</label>
                <input type='text' id='firstName' placeholder='First name' className='usercreate' value={firstName} onChange={event => setFirstName(event.target.value)} />
                <label  className='usercreate'>Last name</label>
                <input type='text' id='lastName' placeholder='Last name' className='usercreate' value={lastName} onChange={event => setLastName(event.target.value)}/>
                <label  className='usercreate'>email</label>
                <input type='text' id='email' placeholder='exampe@google.com' className='usercreate' value={email} onChange={event => setEmail(event.target.value)}/>
                <label  className='usercreate'>year</label>
                <input type='text' id='year' placeholder='1955' className='usercreate' style={{ width: '35px' }} value={year} onChange={event => setYear(event.target.value)}/>
                <input type='button' value='Create' className='usercreate' style={{ width: '100px', margin: '10px' }} onClick={() => onClick()}></input>
  
        </form>
        </div>
    )
}
AddUser.propTypes ={
    addUser: PropTypes.func.isRequired
}
export default AddUser