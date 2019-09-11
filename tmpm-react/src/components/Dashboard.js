import React from 'react';
import ProjectItem from './project/ProjectItem';
import Header from './layout/Header';

class Dashboard extends React.Component {
    render(){
        return (
          <div>
              <Header />
              Welcome
              <ProjectItem />
          </div>
        );
    }
}

export default Dashboard;
