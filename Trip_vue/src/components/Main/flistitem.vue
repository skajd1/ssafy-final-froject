<script setup>
// import { defineProps } from "vue";
defineProps({
  img: String,
});
</script>

<template>
  <div class="item">
    <img :src="img" alt="img" />
  </div>
</template>

<style scoped>
.item {
  min-width: 100%;
  height: 400px;

  margin: 0 5px;
  margin-bottom: 1rem;
  text-align: center;
}
</style>
