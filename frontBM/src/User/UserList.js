import React from 'react';
import PropTypes from 'prop-types';
import UserItem from './UserItem';
import './UserList.css';


 function UserList(props){
  return(
    <table >
      <thead>
     <tr>
      <th>id</th>
      <th>First name</th>
      <th>Last name</th>
      <th>email</th>
      <th>year</th>
     </tr>
     </thead>
     <tbody>
     {props.users.map(user =>{
        return <UserItem user={user} key={user.id}/>
     })
     }
     </tbody>
    </table>
  )
}

UserList.propTypes={
  users: PropTypes.arrayOf(PropTypes.object).isRequired
}
export default UserList;
