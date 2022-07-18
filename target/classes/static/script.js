function loadTasks() {
    fetch('/list-movies').then(response => response.json()).then((moviesList) => {
      const gridContainer = document.getElementById('container');
      moviesList.forEach((movie) => {
        const movieItem = document.createElement('div');
        movieItem.className = 'gallery';
        movieItem.appendChild(createMovieTitle(movie));
        movieItem.appendChild(createMovieImage(movie));
        gridContainer.appendChild(movieItem);
      })
    });

    //Original
    // fetch('/list-movies').then(response => response.json()).then((moviesList) => {
    //   const taskListElement = document.getElementById('list-movies');
    //   tasks.forEach((movie) => {
    //     taskListElement.appendChild(createTaskElement(movie));
    //   })
    // });
  }
  
  /** Creates an element that represents a task, including its delete button. */
  function createMovieTitle(movie) {
    //create title
    const movieTitle = document.createElement('h2');
    movieTitle.className = 'title';
    movieTitle.innerText = movie.title; //ask about this
    return movieTitle;
  }

  function createMovieImage(movie) {
      //create Image
  const movieImg = document.createElement('img');
  movieImg.className = 'image';
  movieImg.src = movie.image;
    return movieImg;
  }

//   /** Tells the server to delete the task. */
//   function deleteTask(movie) {
//     const params = new URLSearchParams();
//     params.append('id', movie.id);
//     fetch('/delete-task', {method: 'POST', body: params});
//   }