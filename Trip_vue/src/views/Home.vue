<script setup></script>

<template>
  <div id="container">
    <div id="title">
      <h1>어디로 가냥?<img src="@/assets/logo1.svg" /></h1>
    </div>
    <div id="search">
      <input type="text" />
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 100px;
  text-align: center;
  margin-top: 2rem;
  color: #ffa18d;
}
#container {
  background-color: var(--vt-c-bg);
  height: 85vh;
}
#search {
  text-align: center;
  margin-top: 2rem;
}
#search input {
  width: 50%;
  height: 50px;
  font-size: 30px;
  border: 1px solid #ffa18d;

  border-radius: 10px;
  outline-color: #ffa18d;
  outline-offset: 2px;
  text-align: center;
}
</style>
