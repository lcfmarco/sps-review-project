function loadTasks() {
    fetch('/list-movies').then(response => response.json()).then((moviesList) => {
      const gridContainer = document.getElementById('container');
      moviesList.forEach((movie) => {
        const movieItem = document.createElement('div');
        movieItem.className = 'gallery';
        movieItem.appendChild(createMovieTitle(movie));
        movieItem.appendChild(createMovieImage(movie));
        movieItem.appendChild(createSubmit());
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

  function createSubmit(){
    const submitContainer = document.createElement('div');
    submitContainer.className = "submitContainer";
        const form = document.createElement('form');
        form.method = "POST";
        form.action = "/post-rating";
            const input = document.createElement('input');
            input.type = "text";
            input.id = "rating";
            input.name = "rating";
            input.placeholder = "Rating out of 10";
            input.className = "submit"
            form.appendChild(input);
            const submitButton = document.createElement('input');
            submitButton.className = "button"
            submitButton.type = "submit";
            submitButton.innerText = "Submit"
            form.appendChild(submitButton);
        submitContainer.appendChild(form)
            // const input = document.createElement('input');
            // input.type = "text";
            // input.placeholder = "Rating out of 10";
            // input.className = "submit"
            // submitContainer.appendChild(input);
            // const submitButton = document.createElement('button');
            // submitButton.className = "button"
            // submitButton.innerText = "Submit"
            // submitContainer.appendChild(submitButton);
    return submitContainer;
  }

//   /** Tells the server to delete the task. */
//   function deleteTask(movie) {
//     const params = new URLSearchParams();
//     params.append('id', movie.id);
//     fetch('/delete-task', {method: 'POST', body: params});
//   }