import React,{useEffect} from 'react';
import './App.css';
import UserList from './User/UserList';
import { restApiHost } from './index';
import Context from './Context';
import AddUser from './User/AddUser';


function App() {
  const [users,setUsers] = React.useState([])

useEffect(()=>{
  fetch(restApiHost+'/all')
  .then(response => response.json() )
  .then(users =>{setUsers(users)})
},[])


  
  function deleteUser(id) {
    fetch(restApiHost+'/delete/' + id)
    .then(response => response.json() 
    .then(result => {if(result)setUsers(
      users.filter(user => user.id !== id)
   )}))
    
  }

  function addUser(data){
    fetch(restApiHost+'/create/', {
      method: "post",
      headers: {
       'Content-Type': 'application/json'
      },
       body: JSON.stringify(data)
     })
    .then( (response) => { 
      setUsers(
        users.concat([])
      )

    })
    
  }

  return (
    <Context.Provider value={{deleteUser}}>
      <div className="wrapper">

        <h1>Users</h1>
        <AddUser onCreate={addUser}></AddUser>
        <UserList users={users}  />
      </div>
    </Context.Provider>
  )
}

export default App
