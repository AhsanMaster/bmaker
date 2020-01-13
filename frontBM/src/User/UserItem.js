import React,{useContext} from 'react'
import PropTypes from 'prop-types'
import Context from '../Context'
import './UserItem.css';


function UserItem({user}){
  const{deleteUser} = useContext(Context);
  return (
    <tr>
      <td>{user.id}</td>
      <td>{user.firstName}</td>
      <td>{user.lastName}</td>
      <td>{user.email}</td>
      <td>{user.year}</td>
      <td className='border_none'><input type="button" value="Delete" onClick={()=> deleteUser(user.id)} style={{}}/>    </td>
    </tr>
  )
}

UserItem.propTypes ={
  user:PropTypes.object.isRequired
}

export default UserItem