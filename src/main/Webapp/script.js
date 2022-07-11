function loadTasks() {
    fetch('/list-movies').then(response => response.json()).then((moviesList) => {
      const taskListElement = document.getElementById('list-movies');
      tasks.forEach((movie) => {
        taskListElement.appendChild(createTaskElement(movie));
      })
    });
  }
  
  /** Creates an element that represents a task, including its delete button. */
  function createMovieElement(movie) {
    const movieElement = document.createElement('li');
    movieElement.className = 'task';
  
    const titleElement = document.createElement('span');
    titleElement.innerText = movie.title;
    directorElement.innerText = movie.director;
    genreElement.innerText = movie.genre;
  
    const deleteButtonElement = document.createElement('button');
    deleteButtonElement.innerText = 'Delete';
    deleteButtonElement.addEventListener('click', () => {
      deleteTask(task);
  
      // Remove the task from the DOM.
      taskElement.remove();
    });
  
    taskElement.appendChild(titleElement);
    taskElement.appendChild(deleteButtonElement);
    return movieElement;
  }

  function createBookElement(book) {
    const bookElement = document.createElement('li');
    bookElement.className = 'task';
  
    const titleElement = document.createElement('span');
    titleElement.innerText = book.title;
    authorElement.innerText = book.director;
    genreElement.innerText = book.genre;
  
    const deleteButtonElement = document.createElement('button');
    deleteButtonElement.innerText = 'Delete';
    deleteButtonElement.addEventListener('click', () => {
      deleteTask(task);
  
      // Remove the task from the DOM.
      taskElement.remove();
    });
  
    taskElement.appendChild(titleElement);
    taskElement.appendChild(deleteButtonElement);
    return movieElement;
  }
  
  /** Tells the server to delete the task. */
  function deleteTask(movie) {
    const params = new URLSearchParams();
    params.append('id', movie.id);
    fetch('/delete-task', {method: 'POST', body: params});
  }