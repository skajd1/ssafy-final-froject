<script setup>
// import { defineProps } from "vue";
defineProps({
  item: String,
});
</script>

<template>
  <div class="item">
    <div class="likecnt">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="20"
        height="18"
        fill="var(--main-color)"
        class="bi bi-heart-fill"
        viewBox="0 0 16 16"
      >
        <path
          color="white"
          fill-rule="evenodd"
          d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"
        />
      </svg>
      {{ item[1] }}
    </div>
    <img v-if="item[2]" :src="item[2]" alt="사진" />
    <img v-else src="@/assets/logo0.svg" alt="사진" />
  </div>
</template>

<style scoped>
.item {
  min-width: 100%;
  height: 400px;
  padding-top: 1rem;
  margin: 0 5px;
  margin-bottom: 1rem;
  text-align: center;
}
img {
  width: 600px;
  border-radius: 10px;
  height: 100%;
  box-shadow: 0 0 8px var(--main-color);
}
.likecnt {
  position: fixed;
  top: 2rem;
  left: 98rem;
  color: white;
  padding-left: 1rem;
  padding-right: 1rem;
  font-size: 3rem;
  font-weight: bold;
  z-index: 1;
  border-radius: 10px;
  background-color: var(--vt-c-text-dark-2);
  box-shadow: 0 0 8px var(--vt-c-text-dark-2);
}
</style>
