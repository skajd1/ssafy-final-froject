<script setup></script>

<template>
  <div id="search">
    <input type="text" placeholder="검색하냥" />
  </div>
</template>

<style scoped>
#search {
  text-align: center;
  margin-top: 2rem;
}
#search input {
  width: 100%;
  height: 50px;
  font-size: 30px;
  border: 1px solid var(--main-color);
  border-radius: 10px;
  outline-color: var(--main-color);
  outline-offset: 2px;
  text-align: center;
  color: var(--main-color);
}
input::placeholder {
  color: var(--vt-c-bg);
}
</style>
