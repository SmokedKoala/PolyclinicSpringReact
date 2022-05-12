import {Route, Routes} from "react-router-dom";
import {hasRole, isAuthenticated} from "../services/auth/auth";
import Profile from "../components/profile/Profile";
import Logout from "../components/logout/Logout";

const MainPageRoutes = ({user}) => {
  return (
      <Routes>
        {/*{hasRole(user, ['admin']) && <Route path='/admin' element={Admin()}/>}*/}
        {isAuthenticated(user) && <Route path='/profile'
                                         element={Profile({user: user})}/>}
        {isAuthenticated(user) && <Route path='/logout'
                                         element={<Logout/>}/>}
      </Routes>
  );
};

export default MainPageRoutes;
