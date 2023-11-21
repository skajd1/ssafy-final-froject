<script setup>
defineProps({
  loading: Boolean,
});
const src = "@/assets/loading.gif";
</script>

<template>
  <div>
    <img v-if="loading" :src="src" alt="loading" />
  </div>
</template>

<style scoped></style>
