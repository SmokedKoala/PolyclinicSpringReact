import {Route, Routes} from "react-router-dom";
import {hasRole, isAuthenticated} from "../services/auth/auth";
import User from "../components/user/User";
import Admin from "../components/admin/Admin";
import Profile from "../components/profile/Profile";
import Department from "../components/department/Department";

const MainPageRoutes = ({user}) => {
  return (
      <Routes>
        {hasRole(user, ['user']) && <Route path='/user' element={User()}/>}
        {hasRole(user, ['admin']) && <Route path='/admin' element={Admin()}/>}
        {isAuthenticated(user) && <Route path='/profile'
                                         element={Profile({user: user})}/>}
      </Routes>
  );
};

export default MainPageRoutes;
